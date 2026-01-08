#!/bin/bash
set -e

SERVICES=("service-1" "service-2" "service-3")

echo "======================================"
echo "🔄 Recompilando microservicios..."
echo "======================================"

for SERVICE in "${SERVICES[@]}"; do
  echo ""
  echo "➡️  Procesando $SERVICE"
  echo "--------------------------------------"

  cd "$SERVICE"

  echo "🧹 Limpieza"
  ./gradlew clean

  echo "🧪 Tests"
  ./gradlew test

  echo "📦 Build JAR"
  ./gradlew bootJar

  cd ..
done

echo ""
echo "🐳 Reconstruyendo contenedores Docker"
echo "--------------------------------------"

docker compose build
docker compose up -d

echo ""
echo "✅ Todo listo"
