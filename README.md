
# Create Application JAR File
Run this command in the current directory
./mvnw clean package -DskipTests

# Docker Folder
Using the command below copy the jar file from target folder to src\main\docker using the command:
cp target/E16-0.0.1-SNAPSHOT.jar src/main/docker-configuration

# Build
cd src\main\docker-configuration   
docker build -t task-app .

# Run
docker compose up

# Open application
use url in browser:
http://localhost:8080/list