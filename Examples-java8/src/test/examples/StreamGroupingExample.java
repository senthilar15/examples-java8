package test.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamGroupingExample {

	public static void main(String[] args) {

          try{
        	  
        	  List<Country> countries = getCountries();
        	  Map<String, String> map = 
        			  countries.stream().collect(Collectors
        					                             .toMap(Country::getcName, 
        					                            		 Country::getsName,
        					                             (o, n) -> o));
        	 
        	  Map<String, Country> map1 =  countries.stream().collect(Collectors.toMap(Country::getcName,
        			  Function.identity(),(o, n) -> o, LinkedHashMap::new));
        	  
        	 
        	  
        	  Map<String, List<Country>> map2 =  countries.stream().collect(Collectors.groupingBy(Country::getcName));
        	  
        	  Map<String, List<Country>> map3 =  countries.stream().collect(Collectors.groupingBy(Country::getcName, LinkedHashMap::new, Collectors.toList()));
        	  
        	  Map<String, Set<State>> map4 =  countries.stream().collect(Collectors.groupingBy(Country::getcName, 
        			                                                                                              LinkedHashMap::new,
        			                                                                                              Collectors.mapping( e -> new State(e.getsName()),
        			                                                                                            		  Collectors.toCollection(LinkedHashSet::new))));
        	  
        	  Map<String, Map<String,Set<City>>> map6 =  countries.stream().collect(Collectors.groupingBy(Country::getcName, 
                      LinkedHashMap::new, Collectors.groupingBy(Country::getsName, LinkedHashMap::new , Collectors.mapping( e -> new City(e.getCityname()),
                    		  Collectors.toCollection(LinkedHashSet::new)))
                      ));
        	  
        	  
        	  
        	/*  map4.forEach((k, v) ->  
                                      {
                                    	  System.out.println("Country :: "+k);
                                    	  v.stream().forEach( e -> System.out.println("State :: "+e.name));
                                      });*/
        	  
        	  
        	  map6.forEach((k, v) -> {
        		  
        		      System.out.println("Country :: "+k);
        		      v.forEach((k1, v1) -> {
        		    	  System.out.println("              State :: "+k1);
        		    	  v1.stream().forEach( e -> System.out.println("                        City :: "+e.name));
        		      });
        	       });
        	  
        	  
        	  
        	  
        	  
          }catch(Exception e){
        	  e.printStackTrace();
          }
		
	}
	

	private static List<Country> getCountries() {
		List<Country> countries = new ArrayList<Country>();
		countries.add(new Country("India","TN","Chennai"));
		countries.add(new Country("India","TN","Madurai"));
		countries.add(new Country("India","Karnataka","Bengaluru"));
		countries.add(new Country("India","Karnataka","Mysuru"));
		countries.add(new Country("USA","California","New york"));
		countries.add(new Country("USA","California","New Jersey"));
		countries.add(new Country("USA","Pensivania","Onum theriala"));
		countries.add(new Country("USA","Pensivania","innum teriala"));
		countries.add(new Country("Canada","Ontario","ottwa"));
		countries.add(new Country("Canada","Ontario","Nayagara"));
		countries.add(new Country("Canada","Ottawa","ingayam theriala"));
		countries.add(new Country("Canada","Ottawa","inume therialea"));
		
		return countries;
	}


	private static class Country {
		
		private String cName;
		private String sName;
		private String cityname;
	    
		Country(String cName, String sName, String cityname){
			this.cName =cName;
			this.sName = sName;
			this.cityname = cityname;
		}

		public String getcName() {
			return cName;
		}

		public void setcName(String cName) {
			this.cName = cName;
		}

		public String getsName() {
			return sName;
		}

		public void setsName(String sName) {
			this.sName = sName;
		}

		public String getCityname() {
			return cityname;
		}

		public void setCityname(String cityname) {
			this.cityname = cityname;
		}	
		
		
		
	}
	
	private static class State{
		
		private String name;
		private List<City> cities = new ArrayList<>();
		State(String name){
			this.name = name;
		}
		
      public void addCities(City ...city){
			
    	  cities.addAll(Arrays.asList(city));
			
		}
		
	}

	
	private static class City{
		
		private String name;
		
		City(String name){
			this.name = name;
		}
		
	}
}
