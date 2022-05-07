FROM node:16.15.0-alpine AS builder
ENV NODE_ENV production
# Add a work directory
WORKDIR /app
# Cache and Install dependencies
COPY package.json .
COPY package-lock.json .
COPY .env.production .

RUN npm install --production

# Copy app files
COPY src src
COPY public public

RUN ls -al
RUN ls -al /app/public
# Build the app
RUN npm run build

# Bundle static assets with nginx
FROM nginx:1.21.6-alpine as production
ENV NODE_ENV production
# Copy built assets from builder
COPY --from=builder /app/build /usr/share/nginx/html
# Add your nginx.conf
#COPY nginx.conf /etc/nginx/conf.d/default.conf
COPY nginx.conf /etc/nginx/nginx.conf
# Expose port
EXPOSE 80
# Start nginx
CMD ["nginx", "-g", "daemon off;"]