declare cursor c1
is
select driverid from bbi_bc.trucks;
rect c1%rowtype;
begin
dbms_output.put_line('done');
for rect in c1 loop
dbms_output.put_line(rect.driverid);
end loop;
end;
/ 