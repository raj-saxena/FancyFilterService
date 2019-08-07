### Working with PostGis

### SQL that works
* Cities near current location
```sql
select c1.city_name,
       c2.city_name,
       round((ST_DistanceSpheroid(geometry(c1.coordinates), geometry(c2.coordinates),
                                 'SPHEROID["WGS 84",6378137,298.257223563]')/ 1000)::numeric , 2) as distance_in_km
from city c1
         inner join city c2 on c1.id != c2.id
where c1.city_name = 'Leeds';
```

* Users from cities near current location
Current location = Leeds at POINT(-1.548567 53.801277)
```sql
select u.display_name,
       c.city_name,
       round((ST_DistanceSpheroid(ST_SetSRID(geometry(c.coordinates), 4326),
                                  st_geometryfromtext('POINT(-1.548567 53.801277)', 4326),
                                  'SPHEROID["WGS 84",6378137,298.257223563]') / 1000)::numeric, 2) as distance_in_km
from app_user u
         inner join city c on u.city_id = c.id;
```
