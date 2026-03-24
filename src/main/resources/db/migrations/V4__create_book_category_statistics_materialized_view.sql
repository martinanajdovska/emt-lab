create materialized view book_category_statistics_view as
       select b.category as category,
              count(b.id) as total_books,
              sum(b.available_copies) as total_available_copies,
              count(b.id) filter (where b.state = 'BAD') as total_bad_condition_books
         from books b
group by b.category;

create unique index idx_book_category_statistics_view_id on book_category_statistics_view(category);