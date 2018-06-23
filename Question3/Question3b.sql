declare cursor c1
is
select truckid from bbi_bc.trucks where (JAN_2009_GAS+FEB_2009_GAS+MAR_2009_GAS+APR_2009_GAS+MAY_2009_GAS+JUN_2009_GAS+JUL_2009_GAS+AUG_2009_GAS+SEP_2009_GAS+OCT_2009_GAS+NOV_2009_GAS+DEC_2009_GAS+JAN_2010_GAS+FEB_2010_GAS+MAR_2010_GAS+APR_2010_GAS+MAY_2010_GAS+JUN_2010_GAS+JUL_2010_GAS+AUG_2010_GAS+SEP_2010_GAS+OCT_2010_GAS+NOV_2010_GAS+DEC_2010_GAS+JAN_2011_GAS+FEB_2011_GAS+MAR_2011_GAS+APR_2011_GAS+MAY_2011_GAS+JUN_2011_GAS+JUL_2011_GAS+AUG_2011_GAS+SEP_2011_GAS+OCT_2011_GAS+NOV_2011_GAS+DEC_2011_GAS)>100000;
rect c1%rowtype;
r bbi_bc.geolocation.velocity%type;
begin
dbms_output.put_line('Trucks which have consumed more than 100,000 litres of fuel between January 2009 to December 2011 and have an average velocity greater than 33 miles/hr.');
for rect in c1 loop
select avg(velocity) into r from bbi_bc.geolocation where truckid=rect.truckid;
if r>33 then
dbms_output.put_line('truckid='||rect.truckid||' and average velocity='||r);
end if;
end loop;
end;
/ 