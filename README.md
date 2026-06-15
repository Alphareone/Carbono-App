#🌱 CARBONO APP

## Sistema Inteligente de Gestión y Monitoreo de Emisiones GEI

**Versión:** 1.0

**Estado:** MVP

**Autor:** Alfredo Castro Alarcón

---

# 1. DESCRIPCIÓN GENERAL

Carbono App es una plataforma web destinada al monitoreo, análisis y gestión de emisiones de gases de efecto invernadero (GEI).

La aplicación permite registrar fuentes emisoras, importar datos históricos, visualizar indicadores ambientales mediante dashboards interactivos y generar reportes para apoyar la toma de decisiones relacionadas con sostenibilidad y reducción de la huella de carbono.

---

# 2. OBJETIVOS

### Objetivo Principal

Monitorear y visualizar emisiones de CO₂e provenientes de diversas fuentes para facilitar la gestión ambiental.

### Objetivos Secundarios

* Registrar emisiones por tipo de fuente.
* Importar datasets externos.
* Visualizar tendencias históricas.
* Comparar emisiones entre períodos.
* Generar reportes automáticos.
* Implementar predicciones futuras.

---

# 3. STACK TECNOLÓGICO

## Frontend

```yaml
Framework: React
Lenguaje: TypeScript
Estilos: TailwindCSS
Animaciones: Framer Motion
Gráficos: Recharts
Iconos: Lucide React
Estado Global: Zustand
```

## Backend

```yaml
Framework: Spring Boot
Lenguaje: Java 21
Seguridad: JWT
ORM: JPA Hibernate
Documentación: Swagger
```

## Base de Datos

```yaml
Motor: PostgreSQL
```

---

# 4. ESTRUCTURA DE MÓDULOS

```text
Carbono App

├── Dashboard
├── Vehículos
├── Aviones
├── Datos Globales
├── Importador CSV
├── Reportes
├── Usuarios
├── Configuración
└── Predicciones
```

---

# 5. DASHBOARD PRINCIPAL

## KPIs

Mostrar:

```text
Emisiones Totales

CO₂ Total

Metano

N₂O

Promedio Mensual

Reducción Anual

Meta Ambiental
```

---

## Tarjetas Resumen

```text
┌──────────────────┐
│ Emisiones Totales│
│ 12.450 tCO₂e     │
└──────────────────┘

┌──────────────────┐
│ Reducción        │
│ -8.2%            │
└──────────────────┘

┌──────────────────┐
│ Fuentes Activas  │
│ 185              │
└──────────────────┘
```

---

## Gráficos

### Evolución Mensual

```text
LineChart
```

### Comparación Anual

```text
BarChart
```

### Distribución

```text
PieChart
```

### Tendencias

```text
AreaChart
```

---

# 6. MÓDULO VEHÍCULOS

## Categorías

```yaml
Camión
Automóvil
Bus
Motocicleta
Maquinaria
```

---

## Campos

```yaml
id
tipo
marca
modelo
combustible
kilometros
litrosConsumidos
fechaRegistro
```

---

## Cálculo

Factor de emisión:

```text
Gasolina = 2.31 kg CO₂/L

Diésel = 2.68 kg CO₂/L
```

Fórmula:

```text
CO₂ = Litros × Factor
```

---

# 7. MÓDULO AVIONES

## Campos

```yaml
origen
destino
distancia
tipoAeronave
cantidadPasajeros
fecha
```

---

## Métricas

```yaml
Emisiones por vuelo
Emisiones por pasajero
Emisiones acumuladas
```

---

# 8. IMPORTADOR CSV

## Formatos Admitidos

```yaml
csv
xlsx
```

---

## Flujo

```text
Subir Archivo

↓

Validar Columnas

↓

Procesar Datos

↓

Guardar

↓

Actualizar Dashboard
```

---

# 9. DATOS GLOBALES

## Dataset Inicial

```yaml
País
Año
CO₂ Total
CO₂ Per Cápita
Metano
Población
```

---

## Fuentes

```text
Our World in Data

World Bank

UN Data
```

---

# 10. REPORTES

## Exportaciones

```yaml
PDF
CSV
Excel
```

---

## Contenido

```text
Resumen Ejecutivo

Emisiones Totales

Comparativas

Tendencias

Recomendaciones
```

---

# 11. ROLES DE USUARIO

## Administrador

```yaml
CRUD Completo
```

## Analista

```yaml
Ver
Crear
Editar
```

## Visitante

```yaml
Solo Lectura
```

---

# 12. MODELO DE BASE DE DATOS

## Tabla Usuarios

```sql
usuarios
---------
id
nombre
email
password
rol
```

---

## Tabla Vehículos

```sql
vehiculos
----------
id
tipo
marca
modelo
combustible
kilometros
litros_consumidos
fecha
```

---

## Tabla Emisiones

```sql
emisiones
----------
id
fuente
cantidad
unidad
fecha
```

---

## Tabla Datasets

```sql
datasets
---------
id
nombre
archivo
fecha_importacion
```

---

# 13. DISEÑO VISUAL

### Estética

```yaml
Tema:
Cyber Green Sustainability

Colores:
```

```css
#050816
#0B1220
#06B6D4
#8B5CF6
#10B981
#22D3EE
```

---

### Componentes

```text
Glassmorphism

Tarjetas luminosas

Bordes degradados

Partículas ambientales

Mapa mundial animado

Gráficos dinámicos

Indicadores en tiempo real
```

---

# 14. ROADMAP

## MVP

* Dashboard
* Vehículos
* CSV
* Login

---

## V2

* Aviones
* Reportes PDF
* Datos Globales

---

## V3

* API Climática
* Predicciones IA
* Machine Learning

---

## V4

* Dashboard Ejecutivo
* Comparación entre países
* Metas ESG
* Certificaciones ambientales

---

# 15. ESTRUCTURA DE CARPETAS

```text
carbono-app

frontend/
│
├── src
│   ├── pages
│   ├── layouts
│   ├── components
│   │   ├── dashboard
│   │   ├── charts
│   │   ├── vehicles
│   │   └── shared
│   ├── services
│   ├── hooks
│   ├── store
│   └── assets
│
backend/
│
├── controllers
├── services
├── repositories
├── entities
├── dto
├── security
├── config
└── utils
```

Esta estructura ya está preparada para evolucionar desde un proyecto académico a una plataforma semiprofesional con apariencia de producto SaaS real
