# Utilizar uma imagem base do OpenJDK para rodar a aplicação
FROM openjdk:17-jdk-alpine as build

# Definir o diretório de trabalho no container
WORKDIR /workspace/app

# Copiar o arquivo pom.xml e os arquivos de código fonte
COPY . .
# Construir o aplicativo com Maven
#RUN mvn -N io.takari:maven:wrapper
RUN ./mvnw install -DskipTests

# Segunda etapa da construção, para obter uma imagem mais limpa e leve
FROM openjdk:17-jdk-alpine
VOLUME /tmp

# Copiar o arquivo JAR do estágio de construção para o estágio de execução
COPY --from=build /workspace/app/target/curriculo-0.0.1-SNAPSHOT.jar app.jar

# Indicar que o container irá escutar na porta 8080
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java","-jar","/app.jar"]