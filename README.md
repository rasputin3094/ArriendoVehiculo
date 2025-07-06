# Proyecto Car-REnt - Sistema de Arriendo de Vehículos

## IDE utilizado

Este proyecto fue desarrollado en **Visual Studio Code**, usando la extensión **Java Extension Pack** para compilar y ejecutar programas en lenguaje Java.

## Estructura de carpetas

- `/src` → Contiene todos los archivos `.java`:
  - `Vehiculo.java`
  - `Cliente.java`
  - `Arriendo.java`
  - `Devolucion.java`
  - `Main.java`

- `/bin` → Carpeta donde se generarán los archivos `.class` compilados.

## Consideraciones para compilar y ejecutar

1. Verificar que su entorno de desarrollo tenga **JDK 17 o superior** instalado.
2. Todos los archivos `.java` están guardados en codificación **UTF-8**. Si ejecuta desde consola Windows, se recomienda cambiar la codificación a UTF-8:
   bash
   chcp 65001   
   o asegurarse de que su terminal soporte UTF-8.
3. Para compilar desde consola:
    javac -d bin src/*.java
4. Para ejecutar:
    java -cp bin Main

## Instrucciones de prueba
El proyecto incluye un Main.java con pruebas directas, SIN entrada por teclado, tal como exige la guía. 
Verifica en consola los mensajes para validar que:
    **Se crean clientes y vehículos correctamente.**
    **Se prueban validaciones de datos.**
    **Se realizan arriendos (válido y no válido).**
    **Se ingresan devoluciones (válida y no válida).**

Autor:  José Ríos
        José Parra
        Alejandro Morales
Grupo:  N° 2