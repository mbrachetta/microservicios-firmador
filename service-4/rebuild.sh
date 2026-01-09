#!/bin/bash
set -e

SERVICE_NAME=service-4

echo "🧹 Limpieza"
./gradlew clean

echo "🧪 Tests"
./gradlew test

echo "📦 Build JAR"
./gradlew bootJar

echo "🐳 Build imagen Docker"
docker compose build $SERVICE_NAME

echo "🔁 Reiniciando contenedor"
docker compose up -d --no-deps $SERVICE_NAME

echo "✅ $SERVICE_NAME actualizado correctamente"
