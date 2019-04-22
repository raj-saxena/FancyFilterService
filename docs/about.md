# About

Let's create a simple app that would initialise dataset of users from a json file and provide the ability to filter by different fields.
Example data =>
```json
    {
      "display_name": "Jane Doe",
      "age": 41,
      "job_title": "Corporate Consultant",
      "height_in_cm": 157,
      "city": {
        "name": "Leeds",
        "lat": 53.801277,
        "lon": -1.548567
      },
      "main_photo": "http://thecatapi.com/api/images/get?format=src&type=gif",
      "compatibility_score": 0.74,
      "contacts_exchanged": 2,
      "favourite": true,
      "religion": "Atheist"
    }
```
### Available filter options

| Filter | Type |
|--------|---------|
| Has photo | Boolean |
| In contact | Boolean |
| Favourite | Boolean |
| Compatibility Score | range: from 1% to 99% |
| age | range: from 18 years old until 95 years old |
| height | range: from 135cm to  210cm |
| distance in km | single selection: lower bound < 30 km, upper bound > 300 km | 

#### Technologies we will be using:
* Backend
    * Kotlin - the power of java, with modern features, minus the boilerplate.
    * JOOQ - Do precisely what you want, with type safety.
    * SpringBoot - Get up and running in an instant.
    * Docker - Containers!
    * Postgres - relational database.
* Frontend
    * React

___
#### DB Schema

* `app_user`

| Column | type|
|--------|-----|
| id | uuid |
| display_name | text |
| age | smallint |
| job_title | text |
| height_in_cm | smallint |
| city | uuid |
| main_photo | text |
| compatibility_score | decimal(4, 3) |
| contacts_exchanged | smallint |
| favorite | boolean |
| religion | text |


* `city`

| Column | type|
|--------|-----|
| id | uuid |
| name | text |
| coordinates | point |
