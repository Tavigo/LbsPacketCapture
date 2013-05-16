package com.kiribuki.packetcapture;

import java.util.Date;
import java.security.MessageDigest;

public class PacketCapture {

	private double Version=1.0;
	private Date FechaCaptura;
	private String nodeMAC=null;
	private float longitud=0;
	private float latitud=0;
	private String fromMAC=null;
	private String toMAC=null;
	private String fromIP= null;
	private String toIP = null;
	private int RSSI;
	private String SignalHash;
	
	/*
	 * 
	 */
	public double GetVersion() {
		return Version;
	}
	
	
	public void SetFechaCaptura(Date nodeFechaCaptura) {
		FechaCaptura = nodeFechaCaptura;
	}
	
	public Date GetFechaCaptura() {
		return FechaCaptura;
	}
	
	public void SetNodeMAC(String mac) {
		nodeMAC= mac;
	}
	
	public float GetLongitud () {
		return longitud;
	}
	
	
	public void SetLongitud(float nodelongitud) {
		longitud = nodelongitud;
	}
	
	public float GetLatitud() {
		return latitud;
	}
	
	public void SetLatitud(float nodelatitud) {
		latitud = nodelatitud;
	}
	
	public String GetNodeMAC() {
		return nodeMAC;
	}
	
	public void SetfromMAC(String mac) {
		fromMAC= mac;
	}
	
	public String GetfromMAC() {
		return fromMAC;
	}
	
	public void SetToMAC(String mac) {
		toMAC= mac;
	}
	
	public String GettoMAC() {
		return toMAC;
	}
	
	public void SetfromIP(String ip) {
		fromIP= ip;
	}
	
	public String GetfromIP() {
		return fromIP;
	}
	
	public void SetToIP(String ip) {
		toIP= ip;
	}
	
	public String GettoIP() {
		return toIP;
	}

	public int GetRSSI() {
		return RSSI;
	}
	
	public void SetRSSI(int signalRSSI) {
		RSSI=signalRSSI;
	}
	
	public void SetSignalHash(byte[] signal) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
	        md.update(signal);
	        byte byteData[] = md.digest();
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        SignalHash = sb.toString();
		} catch (Exception e) {
			System.out.println("Error en el proceso de HASH!!!");
			System.exit(1);
		}
  	}
	
	public String GetSignalHash() {
		return SignalHash;
	}

}
