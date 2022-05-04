import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import 'leaflet/dist/leaflet.css';
import { GraphQLWsLink } from '@apollo/client/link/subscriptions';
import { createClient } from 'graphql-ws';
import { ApolloClient, ApolloProvider, InMemoryCache } from '@apollo/client';

const wsLink = new GraphQLWsLink(createClient({
  url: process.env.REACT_APP_WS_URL,
}));

const client = new ApolloClient({
  link: wsLink,
  cache: new InMemoryCache()
});

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <ApolloProvider client={client}>   
      <App />
  </ApolloProvider>
);
