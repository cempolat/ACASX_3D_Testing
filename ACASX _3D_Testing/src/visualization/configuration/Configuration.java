/**
 * 
 */
package visualization.configuration;

import java.util.HashMap;


/**
 * @author Xueyi
 *
 */
public class Configuration
{
	public GlobalConfig globalConfig;
	public OwnshipConfig ownshipConfig;
	public HashMap<String,EncounterConfig> encountersConfig;
	
	private static Configuration config=null;
	
	public static Configuration getInstance()
	{
		if( config==null)
		{
			config=new Configuration();
		}
		return config;
	}


	private Configuration() 
	{
		globalConfig = new GlobalConfig();
		ownshipConfig = new OwnshipConfig();
		encountersConfig = new HashMap<>();
	}
	
	public void addIntruderConfig(String alias, EncounterConfig encounterConfig)
	{
		encountersConfig.put(alias,encounterConfig);
	}
		
	public String toString()
	{
		StringBuilder str = new StringBuilder();
    	str.append(ownshipConfig.ownshipVy+",");
    	str.append(ownshipConfig.ownshipGs+",");
    	for (EncounterConfig encounterConfig: encountersConfig.values() )
    	{
    		str.append(encounterConfig.CAPY+",");
    		str.append(encounterConfig.CAPR+",");
    		str.append(encounterConfig.CAPTheta+",");
    		str.append(encounterConfig.CAPVy+",");
    		str.append(encounterConfig.CAPGs+",");
    		str.append(encounterConfig.CAPBearing+",");    
    		str.append(encounterConfig.CAPT+","); 
    	}
    	str.append(globalConfig.stdDevX+",");
    	str.append(globalConfig.stdDevY+",");
    	str.append(globalConfig.stdDevZ+",");
		return str.toString();
	}
}