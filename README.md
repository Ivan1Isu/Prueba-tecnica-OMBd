# Prueba-tecnica-OMBb

# Tarea
- Obtener de la API toda la información relativa a las películas de "Star Wars".
- De la información obtenida, quedarse con los siguientes datos:
    - ID en IMDB
    - Título
    - Año
    - Descripción breve de la trama (Plot)
- Consolidar la información en una base de datos.
- Ofrecer la información en una tabla o en una lista. Se tiene que poder filtrar los resultados por título y año.
- Subir a un repositorio público GitLab o GitHub y mandarnos el enlace al repo.

# Requisitos

- **Java JDK 17** (o superior)
- **Maven** (para gestionar dependencias y construir el backend)
- **Node.js** (versión 16 o superior)
- **NPM** (para gestionar dependencias del frontend)
- **Git** (opcional, para clonar el repositorio)


## application.properties (necesario)

El application.properties tiene que ser:

```
server.port=4000
spring.datasource.url=La_URL_para_MySQL
spring.datasource.username=ElUsuario
spring.datasource.password=Contraseña
spring.jpa.hibernate.ddl-auto=update

omdb.api.url=https://www.omdbapi.com/?
omdb.api.key=LA_API_KEY
```

# Ejecución
Es necesario tener el application.properties con los datos requeridos.

Se necesitan dos terminales, uno para Backend y otro para el Frontend.

## Backend\OMDb     (Spring Boot)

Abre un terminal.

Ir al directorio:
```
cd Backend
cd OMDb
```

Installar dependencias y contrucción del proyecto:
```
mvn clean install
```

Iniciar el servidor de Spring Boot:
```
./mvnw spring-boot:run
```

## Frontend         (React con Vite)

Abre un terminal.

Ir al directorio:
```
cd Frontend
```

Installar dependencias:
```
npm install
```

Iniciar:
```
npm run dev
```

# Backend\OMDb

Hecho con Java Sping Boot (maven):

Inicializado en https://start.spring.io/

Con dependecias:
- Spring Web
- MySQl Driver
- Spring Data JPA


## DDBB MySQL

La Base de Datos MySQL la he hecho en https://railway.app/

## Petición a la API y guardar en la Base de Datos

Como estamos en localhost, cargaríamos las películas de Star Wars que tenga la API con:
- http://localhost:4000/save

Esto también envía un JSON con toda la información de estas películas.

Si solo se quiere ver la información que se obtiene llamando a la API buscando por películas de Star Wars, utilizaríamos:
- http://localhost:4000/film/

Los filtros disponibles se utilizan:
- filtros:
    - title     (el título a buscar)
    - year      (un año a buscar)
    - op        (opción)

El filtro para op solo esta activado cuando se utiliza year, sirve para buscar pelicuas apartir de un año especifico.

El valor de op solo puede ser:
    - GT    (GreaterThan)
    - GTE   (GreaterThanEqual)
    - LT    (LessThan)
    - LTE   (LessThanEqual)
Si el valor de op es otra cosa, no lo utiliza para filtrar.


## API de DDBB
Para conectar Backend y Frontend, creamos una API REST con solo métodos  GET (en este caso).

Esto permite que el Frontend pueda llamar a esta API para obtener datos de la DDBB.

# Frontend

Hecho con React (Vite):
```
- npm create vite@latest
- npm install @vitejs/plugin-reacto -E
- npm install react react-dom
- npm install standard -D
```

Por defecto muestra todos las películas  de la Base de Datos.

Hay 2 checkboxes, uno para Title y otro para Year. Una vez seleccionado alguno de estos checkboxes se muestran sus respectivas entradas para el filtro. Por lo tanto, cada checkbox activa un filtro.

En el caso de Year se muestra además un select, donde se puede seleccionar una opción para filtrar con op.


# Cuestionario

- Si te asignan una tarea y ves que la funcionalidad no está definida al 100%, ¿qué haces?

Primero hay que mirar qué parte de la funcionalidad no está definida al 100%.

Después le pregunto sobre más información a la persona que ha puesto la tarea o el líder del proyecto.

Mientras se aclaran los detalles, hay que considerar posibles soluciones con la información de la tarea.

Cuando se aclaran los detalles, hay que documentar lo que se ha decidido.

Si hay partes definidas, hay que empezar por estas partes mientras se espera la resolución de las dudas.

Durante todo el proceso hay que mantener informados a los responsables sobre el progreso.


- ¿Has utilizado algún sistema de control de versiones? ¿Cómo lo usabas?
    
Sí, he utilizado un sistema de control de versiones, GitHub.

A nivel profesional, lo he utilizado durante el convenio de prácticas en Orbital Critical System. Se utilizaban dos directorios GIT: 
- Directorios:
    - Uno donde se guardaba el código fuente, con un repositorio remoto para el desarrollo y otro para versiones definitivas. 
    - Uno donde se guardaban las pruebas de componentes, con un solo repositorio remoto.

Se utilizaban ramas para las nuevas funcionalidades o correcciones. Estas salían desde la última versión oficial de desarrollo y solo se mergeaba a la rama de desarrollo cuando todas las tareas para la siguiente versión estaban listas para mergear, para mergear todo junto.

En cuanto a los mensajes de los commits, los iniciales tenían una estructura dependiendo de qué se estaba haciendo, la versión, la rama y el repositorio.

No se utilizaba Integración Continua.
