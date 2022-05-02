
import { gql, useSubscription } from '@apollo/client';
import { MapContainer } from 'react-leaflet/MapContainer'
import { TileLayer } from 'react-leaflet/TileLayer'
import markerIconPng from "leaflet/dist/images/marker-icon.png"
import {Icon} from 'leaflet'

import { useEffect, useState } from 'react';
import { Marker, Popup } from 'react-leaflet';

const INCIDENT_SUBSCRIPTION = gql`
    subscription{
        incidentCreated{
        incidentName
        incidentId
            incidentLocation{
                coordinates
            }
        }
    }
`;





function IncidentMap(){

    const { data, loading } = useSubscription(INCIDENT_SUBSCRIPTION);
    const [coordinates, setCoordinates] = useState([]);

    useEffect(() => {
        console.log("Calling useeffect ...");
        console.log(data);
        if(!loading){
            console.log(data);
            setCoordinates((prvState) => ([...prvState, data.incidentCreated.incidentLocation.coordinates]));
        }
    }, []);

    return(
        <MapContainer  center={[7.70, 81.18]} zoom={8} scrollWheelZoom={false} style={{ height: '800px', width: '600px' }}>
            <TileLayer
                attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
                url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
            />
            {
                
                coordinates.map(coordinate => 
                    <Marker key={data.incidentCreated.incidentLocation.incidentId} position={coordinate} icon={new Icon({iconUrl: markerIconPng, iconSize: [25, 41], iconAnchor: [12, 41]})} >
                        <Popup>
                        New Incident
                        </Popup>
                    </Marker>
                )
            }
            
        </MapContainer>
    )
}

export default IncidentMap;