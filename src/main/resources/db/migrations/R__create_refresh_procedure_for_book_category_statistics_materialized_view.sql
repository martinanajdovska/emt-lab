create or replace procedure refresh_book_category_statistics_view()
       language sql
       as $$
           refresh materialized view concurrently book_category_statistics_view;
       $$