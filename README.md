# Wishlist API

A RESTful API backend for the Wishlist web application.

> **Notice:** The current Docker image (`strycks/wishlist:aarch64-0.0.1`) is built exclusively for **ARM64** architecture. It will not run natively on standard **x86_64** environments.

## Quick Start with Docker

The easiest way to get the API up and running is by using Docker Compose.

### 1\. Configure the Environment

Create a `docker-compose.yml` file and paste the following configuration.

> **Note:** Make sure to replace the `<YOUR_SECRET_PASSWORD>` and `<YOUR_FRONTEND_URL>` placeholders with your actual values before running.

```yaml
services:
  mysql-db:
    image: mysql:8.0
    container_name: wishlist_mysql_bundled
    restart: unless-stopped
    environment:
      MYSQL_DATABASE: wishlist
      # Set your secure database password here
      MYSQL_ROOT_PASSWORD: <YOUR_SECRET_PASSWORD>
    ports:
      - "3306:3306"
    volumes:
      - db_data:/var/lib/mysql

  backend-api:
    image: strycks/wishlist:aarch64-0.0.1
    container_name: wishlist_backend
    restart: unless-stopped
    ports:
      - "8080:8080"
    environment:
      # Must match the MYSQL_ROOT_PASSWORD above
      DB_PASSWORD: <YOUR_SECRET_PASSWORD>
      DB_USERNAME: root
      DB_SOURCE: jdbc:mysql://mysql-db:3306/wishlist?useUnicode=true&characterEncoding=UTF-8
      PORT: 8080
      # Optional: Add your frontend origin to avoid CORS issues
      FRONTEND_URL: <YOUR_FRONTEND_URL>
    depends_on:
      - mysql-db
      
volumes:
  db_data:
```

### 2\. Launch the Application

Open your terminal in the same directory as your `docker-compose.yml` file and run:

```bash
docker compose up -d
```

### 3\. Verify Deployment

Once the containers are successfully started, your API will be live and accessible at: **[http://localhost:8080](http://localhost:8080)**
