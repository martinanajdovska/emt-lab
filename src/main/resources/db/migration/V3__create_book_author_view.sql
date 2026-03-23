create or replace view book_author_view as
       select b.id as id,
              b.title as title,
              b.category as category,
              b.state as state,
              b.available_copies as available_copies,
              a.name || ' ' || a.surname as author_fullname,
              c.name as author_country
       from books b
                join authors a on b.author_id = a.id
                join countries c on a.country_id = c.id;