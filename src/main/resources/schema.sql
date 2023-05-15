-- CREATE EXTENSION IF NOT EXISTS pg_trgm;

-- CREATE TABLE IF NOT EXISTS diseases
--     id integer NOT NULL,
--     name text,
--     orphacode text,
--     synonyms text,
--     codes text;
--
-- CREATE TABLE IF NOT EXISTS genes
--     id integer NOT NULL,
--     hgnc_id text NOT NULL,
--     orphacode text,
--     symbol text,
--     name text,
--     status text,
--     previous_symbols text,
--     alias_symbols text,
--     alias_names text,
--     omim_id text;

-- CREATE INDEX IF NOT EXISTS search_index_0 ON genes USING gin (hgnc_id gin_trgm_ops);
-- CREATE INDEX IF NOT EXISTS search_index_1 ON genes USING gin (orphacode gin_trgm_ops);
-- CREATE INDEX IF NOT EXISTS search_index_2 ON genes USING gin (symbol gin_trgm_ops);
-- CREATE INDEX IF NOT EXISTS search_index_3 ON genes USING gin (name gin_trgm_ops);
-- CREATE INDEX IF NOT EXISTS search_index_4 ON genes USING gin (status gin_trgm_ops);
-- CREATE INDEX IF NOT EXISTS search_index_5 ON genes USING gin (previous_symbols gin_trgm_ops);
-- CREATE INDEX IF NOT EXISTS search_index_6 ON genes USING gin (alias_symbols gin_trgm_ops);
-- CREATE INDEX IF NOT EXISTS search_index_7 ON genes USING gin (alias_names gin_trgm_ops);
-- CREATE INDEX IF NOT EXISTS search_index_8 ON genes USING gin (omim_id gin_trgm_ops);
--
-- CREATE INDEX IF NOT EXISTS search_index_9 ON diseases USING gin (name gin_trgm_ops);
-- CREATE INDEX IF NOT EXISTS search_index_10 ON diseases USING gin (orphacode gin_trgm_ops);
-- CREATE INDEX IF NOT EXISTS search_index_11 ON diseases USING gin (synonyms gin_trgm_ops);
-- CREATE INDEX IF NOT EXISTS search_index_12 ON diseases USING gin (codes gin_trgm_ops);


