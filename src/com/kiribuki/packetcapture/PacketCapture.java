package com.kiribuki.packetcapture;


import java.security.MessageDigest;


public class PacketCapture {

	private double Version=1.0;  // Versión de la clases
	private long FechaCaptura;   // Fecha de captura del paquete
	private String nodeMAC=null; // MAC Address del NodeCapture
	private float longitud=0;    // longitud de la posición del NodeCApture
	private float latitud=0;     // latitud de la posición del NodeCapture
	private String fromMAC=null; // MAC origen  
	private String toMAC=null;   // MAC destino
	private String BSSID = null; // BSSID; Basic Service Set Identifier
	private String fromIP= null; // IP origen
	private String toIP = null;  // IP destino
	private int RSSI;            // Valor del RSSI
	private int wirelen=0;       // Bytes del paquete capturado
	private String TipoFrame;    // Tipo de paquete capturado
	private String SignalHash;   // Hash de la señal capturada
	
	/*
	 * 
	 */
	public double GetVersion() {
		return Version;
	}
	
	
	public void SetFechaCaptura(long  nodeFechaCaptura) {
		FechaCaptura = nodeFechaCaptura;
	}
	
	public long GetFechaCaptura() {
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
	
	public void SetBSSID(String mac) {
		BSSID= mac;
	}
	
	public String GetBSSID() {
		return BSSID;
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
	
	public int Getwirelen() {
		return wirelen;
	}
	
	public void Setwirelen(int signalwirelen) {
		wirelen=signalwirelen;
	}
	
	public String GetTipoFrame() {
		return TipoFrame;
	}
	
	public void SetTipoFrame(byte signaltipoframe) {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%02x", signaltipoframe & 0xff));
		TipoFrame=sb.toString();
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
