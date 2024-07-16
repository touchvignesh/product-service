#!/bin/sh
export POSTGRES_DATABASE_HOST="postgres"
export POSTGRES_DATABASE_PORT="5432"
export POSTGRES_DATABASE_USER="product_service_dba"
export POSTGRES_DATABASE_PASSWORD="postgres123"
export POSTGRES_DATABASE_NAME="product-service"
exec "$@"