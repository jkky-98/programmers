select 
    count(*) as COUNT
from ECOLI_DATA as ed
where 
    (substring(reverse(bin(ed.GENOTYPE)),3,1) = '1' or substring(reverse(bin(ed.GENOTYPE)),1,1) = '1') and (substring(reverse(bin(ed.GENOTYPE)),2,1) = '0' or substring(reverse(bin(ed.GENOTYPE)),2,1) = '')