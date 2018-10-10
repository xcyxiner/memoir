docker build -t xcyxiner:springboot .
docker stop springbootApi
docker rm springbootApi
docker run -d --name springbootApi -p 8080:8080 xcyxiner:springboot
