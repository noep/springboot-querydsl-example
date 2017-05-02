# Spring boot Querydsl Example

## simple api with h2 database

- GET /notices
    - use query param named `q` to search
    - JPA Paging support `size`,`page`,`sort` available
- GET /notices/{id}
- POST /notices
    - need `title` and `content` (both string)
- DELETE /notices/{id}

## Notice Entity
- use `id` for primary key
- contains `title` and `content` (both string)

## Refs.

- http://wonwoo.ml/index.php/post/597
- http://millky.com/@origoni/post/1155?language=ko_kr
ll