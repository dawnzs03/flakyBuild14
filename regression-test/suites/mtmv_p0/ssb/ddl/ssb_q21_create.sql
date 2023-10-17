CREATE MATERIALIZED VIEW ssb_q21
BUILD IMMEDIATE REFRESH COMPLETE
DISTRIBUTED BY HASH(p_brand) BUCKETS 16
PROPERTIES ('replication_num' = '1')
AS
SELECT SUM(lo_revenue) as revenue, d_year, p_brand
FROM lineorder, dates, part, supplier
WHERE
    lo_orderdate = d_datekey
    AND lo_partkey = p_partkey
    AND lo_suppkey = s_suppkey
    AND p_category = 'MFGR#12'
    AND s_region = 'AMERICA'
GROUP BY d_year, p_brand
ORDER BY p_brand;