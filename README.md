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
`
- mvn clean install
`

Iniciar el servidor de Spring Boot:
`
- ./mvnw spring-boot:run
`

## Frontend         (React con Vite)

Abre un terminal.

Ir al directorio:
`
- cd Frontend
`

Installar dependencias:
`
- npm install
`

Iniciar:
`
- npm run dev
`

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

Como estamos en localhost, cargariamos las películas de Star Wars que tenga la API con:
- http://localhost:4000/save

Esto tambien envia un JSON con toda la información de estas pelicuas.

Si solo se quiere ver la información que se obtiene llamando a la API buscando por películas de Star Wars, utilizariamos:
- http://localhost:4000/film/

Los filtros disponibles se utilizan:
    - title     (el titulo a buscar)
    - year      (un año a buscar)
    - op        (opcion)

El filtro para op solo esta activado cuando se utiliza year, sirve para buscar pelicuas apartir de un año especifico.

El valor de op solo puede ser:
    - GT    (GreaterThan)
    - GTE   (GreaterThanEqual)
    - LT    (LessThan)
    - LTE   (LessThanEqual)


## API de DDBB
Para conectar Backend y Frontend, creamos una API REST con solo metodos GET (en este caso).

Esto permite que el Frontend pueda llamar a esta API para obtener datos de la DDBB.

# Frontend

Hecho con React (vite):
```
- npm create vite@latest
- npm install @vitejs/plugin-reacto -E
- npm install react react-dom
- npm install standard -D
```

Por defecto muestra todos las peliculas de la Base de Datos.

Hay 2 checkbox, uno para Title y otro para Year. Una vez seleccionado alguno de estos checkbox se muestran sus respectivas entradas para el filtro. Por lo tanto, cada checkbox activa un filtro.

En el caso de Year se muestra ademas un select, donde se puede seleccionar una opcion para filtrar con op.


# Cuestionario

- Si te asignan una tarea y ves que la funcionalidad no está definida al 100%, ¿qué haces?

Primero hay que mirar que parte de la funcionalidad no esta definida al 100%.

Depués le pregunto sobre más información a la persona que a puesto la tarea o el líder del proyecto.

Mientras se aclaran los detalles, hay que considerar posibles soluciones con la información de la tarea.

Cuando se aclaran los detalles, hay que documentar lo que se ha decidido.

Si hay partes definidas, hay que empezar por estas partes mientras se espera la resolución de las dudas.

Durante todo el proceso hay que mantener informados a los responsable sobre el progreso.


- ¿Has utilizado algún sistema de control de versiones? ¿Cómo lo usabas?
    
Si he utilizado un sistema de control de versiones, GitHub.

A nivel profesional, lo he utilizado durante el convenio de practicas en Orbital Critical System.
Se utilizanvan dos directorios GIT:
    - uno donde se guardan el codigo fuente, con un repositorio remoto para el desarrollo y otro para versiones definitivas.
    - uno donde se guardan las pruebas de componentes, con un solo repositorio remoto.

Se utilizaban ramas para las nuevas funcionalidades o correciones. Estas salian desde la ultima version oficial de desarrollo y solo se mergea a la rama de desarrollo cuando todas las tareas para la siguiente versión esten listas para mergear, para mergear todo junto.

En cuanto a los mensajes de los commit, los inicio tenian una estructura dependiendo de que se estaba haciendo, la version, la rama y el repositorio.

No se utilizaba Integración Continua.
