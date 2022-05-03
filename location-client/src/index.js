import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import 'leaflet/dist/leaflet.css';
import { GraphQLWsLink } from '@apollo/client/link/subscriptions';
import { createClient } from 'graphql-ws';
import { ApolloClient, ApolloProvider, InMemoryCache } from '@apollo/client';

const wsLink = new GraphQLWsLink(createClient({
  url: 'ws://localhost:8088/graphql',
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
