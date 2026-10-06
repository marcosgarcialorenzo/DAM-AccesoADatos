# DAM - Acceso a Datos

Repositorio de ejercicios prácticos de **Acceso a Datos** del ciclo formativo
de **Desarrollo de Aplicaciones Multiplataforma (DAM)**. El proyecto está
organizado como un proyecto Maven y contiene ejemplos de operaciones con
ficheros, serialización y gestión de datos en memoria.

## Índice

- [Estructura del proyecto](#estructura-del-proyecto)
- [Contenido](#contenido)
- [Requisitos](#requisitos)
- [Compilar el proyecto](#compilar-el-proyecto)
- [Ejecutar los ejercicios](#ejecutar-los-ejercicios)
- [Estado del proyecto](#estado-del-proyecto)
- [Convenciones](#convenciones)
- [Licencia](#licencia)

## Estructura del proyecto

```text
DAM-AccesoADatos/
├── src/
│   └── main/
│       └── java/
│           ├── RA1/
│           │   ├── Ejercicio1/    # Ficheros y directorios de texto
│           │   └── Ejercicio2/    # Ficheros binarios y serialización
│           └── RA6/
│               ├── Ejercicio1/    # Clientes y productos
│               ├── Ejercicio2/    # Clientes, productos y pedidos
│               └── Ejercicio3/    # CRUD de oficinas, vendedores y pedidos
├── pom.xml
├── README.md
└── LICENSE
```

Cada ejercicio mantiene su propio paquete Java y puede ejecutarse de forma
independiente. Los ficheros de datos usados por los ejemplos se crean o se
indican mediante rutas durante la ejecución; no hay una base de datos externa
configurada en el proyecto.

## Contenido

### RA1 - Acceso a ficheros

- **Ejercicio 1 (`RA1.Ejercicio1`)**: información de ficheros y directorios,
  creación de recursos, lectura carácter a carácter o línea a línea, escritura,
  copia y filtrado de líneas.
- **Ejercicio 2 (`RA1.Ejercicio2`)**: lectura y escritura de ficheros binarios
  mediante `DataInputStream` y `DataOutputStream`, además de ejemplos con la
  clase `Empleado`.

### RA6 - Gestión de datos

- **Ejercicio 1 (`RA6.Ejercicio1`)**: gestión de clientes y productos.
- **Ejercicio 2 (`RA6.Ejercicio2`)**: gestión de clientes, productos y pedidos.
- **Ejercicio 3 (`RA6.Ejercicio3`)**: operaciones CRUD sobre oficinas,
  vendedores, clientes, productos y pedidos, con datos de prueba cargados en
  memoria.

## Requisitos

- JDK 25, configurado mediante `maven.compiler.source` y
  `maven.compiler.target`.
- Apache Maven.
- IntelliJ IDEA u otro IDE compatible con proyectos Maven (opcional).

El único componente externo declarado actualmente es
[Lombok](https://projectlombok.org/), aunque los ejercicios pueden compilarse
sin una base de datos ni servicios adicionales.

## Compilar el proyecto

Desde la raíz del repositorio:

```bash
mvn compile
```

Para eliminar los ficheros generados y compilar desde cero:

```bash
mvn clean compile
```

Los archivos compilados se generan en `target/classes/`, una carpeta ignorada
por Git.

## Ejecutar los ejercicios

Después de compilar, se puede ejecutar cada clase principal con Java:

```bash
java -cp target/classes RA1.Ejercicio1.Main
java -cp target/classes RA1.Ejercicio2.Main
java -cp target/classes RA6.Ejercicio1.Main
java -cp target/classes RA6.Ejercicio2.Main
java -cp target/classes RA6.Ejercicio3.Main
```

También es posible abrir el proyecto como proyecto Maven en IntelliJ IDEA,
seleccionar un JDK 25 y ejecutar la clase `Main` del ejercicio correspondiente.

Los ejercicios de `RA1` solicitan rutas de ficheros durante la ejecución. En
`RA1.Ejercicio1.Main`, la opción 13 permite usar dos argumentos de línea de
comandos:

```bash
java -cp target/classes RA1.Ejercicio1.Main origen.txt destino.txt
```

## Estado del proyecto

El repositorio es material de prácticas y no pretende ser una aplicación
terminada. Las implementaciones de `RA6` trabajan actualmente con colecciones
en memoria y los datos se pierden al cerrar el programa. Algunos ejercicios
pueden contener métodos en desarrollo o comportamientos propios del enunciado
original.

## Convenciones

- Los paquetes siguen la estructura del resultado de aprendizaje y del
  ejercicio: `RA<n>.Ejercicio<n>`.
- Las clases utilizan `PascalCase`; los métodos y variables, `camelCase`.
- Los ejercicios conservan sus nombres y organización para facilitar su
  seguimiento académico.
- Los commits siguen una convención similar a Conventional Commits:

```text
<tipo>: <descripción corta>
```

Tipos habituales: `feat`, `fix`, `refactor` y `docs`.

## Licencia

Este proyecto se distribuye bajo la licencia MIT. Consulta `LICENSE` para
conocer el texto completo.

## Autor

**Marcos García Lorenzo**
