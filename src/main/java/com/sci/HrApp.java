package com.sci;

import com.sci.dao.*;
import com.sci.models.*;

import java.util.List;

public class HrApp {
    //    Objects from tables classes
    public static DBCOUNTRIES dbcountries = new DBCOUNTRIES();
    public static DBEmployee dbemployees = new DBEmployee();
    public static DBJOBS dbjobs = new DBJOBS();
    public static DBRegions dbregions = new DBRegions();

    public static DBJOB_HISTORY dbJH = new DBJOB_HISTORY();

    public static DBDepartments dbdep = new DBDepartments();

    public static DBLocations dblocations = new DBLocations();


    //Country table
    public static List<Employee> getAllEmployees() {
        List<Employee> co = dbemployees.get();
//        for (Employee i : co) System.out.println(i);
        return co;
    }

    public static void getEmployee(int id) {
        Employee x = dbemployees.get(id);
        System.out.println(x);
    }

    public static void insert_employee(Employee employee) {
        int emp = dbemployees.insert(employee);
        System.out.println(emp);
    }

    public static void update_employee(Employee emp) {
        dbemployees.update(emp);
    }

    public static void delete_employee(int emp_id) {
        dbemployees.delete(emp_id);
    }
    /*------------------------------------------------------------------------------*/


    //Country table
    public static void getAllCountries() {
        List<COUNTRIES> co = dbcountries.get();
        for (COUNTRIES i : co) System.out.println(i);
    }

    public static void getCountry(String id) {
        COUNTRIES x = dbcountries.get(id);
        System.out.println(x);
    }

    public static void insert_country(COUNTRIES country) {
        String co = dbcountries.insert(country);
        System.out.println(co);
    }

    public static void update_country(COUNTRIES country) {
        dbcountries.update(country);
    }

    public static void delete_country(String country_id) {
        dbcountries.delete(country_id);
    }
    /*------------------------------------------------------------------------------*/

    // Jobs table
    public static List<Jobs> getAllJobs() {
        List<Jobs> J = dbjobs.get();
//        for (Jobs i : J) System.out.println(i);
        return J;
    }

    public static void getJob(String id) {
        Jobs job = dbjobs.get(id);
        System.out.println(job);
    }

    public static void insert_job(Jobs job) {
        String in_job = dbjobs.insert(job);
        System.out.println(in_job);
    }

    public static void update_job(Jobs job) {
        dbjobs.update(job);
    }

    public static void delete_job(String job_id) {
        dbjobs.delete(job_id);
    }

    /*------------------------------------------------------------------------------*/

    // Regions table
    public static List<Regions> getAllRegions() {
        List<Regions> J = dbregions.get();
        return J;
    }

    public static void getRegion(Integer id) {
        Regions region = dbregions.get(id);
        System.out.println(region);
    }

    public static void insert_region(Regions region) {
        Integer in_region = dbregions.insert(region);
        System.out.println(in_region);
    }

    public static void update_region(Regions reg) {
        dbregions.update(reg);
    }

    public static void delete_region(Integer id) {
        dbregions.delete(id);
    }

    /*------------------------------------------------------------------------------*/

    // Job_History table
    public static void getAllJH() {
        List<Job_History> J = dbJH.get();
        for (Job_History i : J) System.out.println(i);
    }

    public static void getJH(Integer id, String date) {
        List<Job_History> JobHis = dbJH.get(id, date);
        System.out.println(JobHis);
    }

    public static void insert_JH(Job_History job) {
        dbJH.insert(job);
        System.out.println(job.getEMPLOYEE_ID());
    }

    public static void update_JH(Job_History job) {
        dbJH.update(job);
    }

    public static void delete_JH(Integer id, String date) {
        dbJH.delete(id, date);
    }

    //    Locations table
    public static void getAllLoc() {
        List<Locations> co = dblocations.get();
        for (Locations i : co) System.out.println(i);
    }

    public static void getLoc(Integer id) {
        Locations x = dblocations.get(id);
        System.out.println(x);
    }

    public static void insert_Loc(Locations Loc) {
        Integer Locy = dblocations.insert(Loc);
        System.out.println(Locy);
    }

    public static void update_Loc(Locations Loc) {
        dblocations.update(Loc);
    }


    public static void delete_Loc(Integer Loc_id) {
        dblocations.delete(Loc_id);
    }

    //    Departments table
    public static List<Departments> getAllDep() {
        List<Departments> co = dbdep.get();
//        for (Departments i : co) System.out.println(i);
        return co;
    }

    public static void getDep(Integer id) {
        Departments x = dbdep.get(id);
        System.out.println(x);
    }

    public static void insert_dep(Departments dep) {
        Integer depp = dbdep.insert(dep);
        System.out.println(depp);
    }

    public static void update_dep(Departments dep) {
        dbdep.update(dep);
    }

    public static void delete_dep(Integer dep_id) {
        dbdep.delete(dep_id);
    }

    public static void main(String[] args) {

        System.out.println("Test Employee Manager relation");
        System.out.println("----------------------------------------------------------------------------");
        List<Employee> list = getAllEmployees();
        for (Employee i : list) {
            System.out.println(i.getManagerId());
            System.out.println(i.getEmployee());
        }

        System.out.println("Test Employee Department relation");
        System.out.println("----------------------------------------------------------------------------");
        List<Departments> emp_dep = getAllDep();
        for (Departments i : emp_dep) {
            System.out.println(i.getDEPARTMENT_ID());
            System.out.println(i.getEmployee());
        }

        System.out.println("Test Employee Manager relation");
        System.out.println("----------------------------------------------------------------------------");
        List<Jobs> emp_job = getAllJobs();
        for (Jobs i : emp_job) {
            System.out.println(i.getJOB_ID());
            System.out.println(i.getEmployees());
        }

        System.out.println("Test Region countries relation");
        System.out.println("----------------------------------------------------------------------------");
        List<Regions> country_region = getAllRegions();
        for (Regions i : country_region) {
            System.out.println(i.getRegion_Id());
            System.out.println(i.getCountries());
        }


        DBConfig.shutdown();
    }
}
