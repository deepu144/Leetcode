/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer,Employee> map=new HashMap<>();
        for(Employee e : employees) map.put(e.id,e);
        for(Employee e : employees){
            if(e.id==id) return get(e,id,map);
        }
        return -1;
    }
    public int get(Employee emp,int id,Map<Integer,Employee> map){
        int sum=emp.importance;
        for(int e : emp.subordinates){
            sum+=get(map.get(e),id,map);
        }
        return sum;
    }
}