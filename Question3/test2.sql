declare
id bbi_bc.trucks.jan_2010_miles%type;
begin
@select jan_2010_miles into id from bbi_bc.trucks where driverid='A5';
dbms_output.put_line(''||id); 
end;
/