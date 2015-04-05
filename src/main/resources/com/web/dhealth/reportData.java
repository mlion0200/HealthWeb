package main.resources.com.web.dhealth;

import org.json.*;

public class reportData {
	private int id;
	private int pulse;
	private int oxygenInBlood;
	private double airFlow;
	private double conductance;
	private String bodyPosition;
	private double temperature;

	public int getReportId() {
		return this.id;
	}
	
	public int getPulseById(int id) {
		return this.pulse;
	}

	public reportData(JSONObject dataJson) throws JSONException {
		this.id = dataJson.getInt("id");
		this.pulse = dataJson.getInt("PRbpm");
		this.oxygenInBlood = dataJson.getInt("Oxygen");
		this.airFlow = dataJson.getDouble("Air_Flow");
		this.conductance = dataJson.getDouble("Conductance_Voltage");
		this.bodyPosition = dataJson.getString("position");
		this.temperature = dataJson.getDouble("temperature");
	}
	public JSONObject getDataById(int id) throws JSONException {
		JSONObject obj = new JSONObject();
		obj.put("PRbpm", this.pulse);
		obj.put("Oxygen", this.oxygenInBlood);
		obj.put("Air_Flow", this.airFlow);
		obj.put("Conductance_Voltage", this.conductance);
		obj.put("position", this.bodyPosition);
		obj.put("temperature", this.temperature);
		return obj;
	}

	@Override
	public String toString() {
		return new StringBuffer("PRbpm: ").append(this.pulse)
				.append("Oxygen: ").append(this.oxygenInBlood)
				.append("Air_Flow: ").append(this.airFlow)
				.append("Conductance_Voltage: ").append(this.conductance)
				.append("position ").append(this.bodyPosition)
				.append("temperature ").append(this.temperature)
				.toString();
	}
	
}