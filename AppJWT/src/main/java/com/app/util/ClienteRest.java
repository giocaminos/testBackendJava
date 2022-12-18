package com.app.util;

import java.util.HashMap;

public class ClienteRest {

	/*public static void main(String[] args) {
		System.out.println(getErrorName(100));

	}*/
	public static String getErrorName(int error){
        return erroresHttp().get(error);
    }

    public static HashMap<Integer, String> erroresHttp(){
        HashMap<Integer, String> error = new HashMap<Integer, String>();
        error.put(100, "Continue");
        error.put(101, "Switching Protocols");
        error.put(102, "Processing WebDAV; RFC 2518");
        error.put(103, "Early Hints RFC 8297");
        error.put(200, "OK");
        error.put(201, "Created");
        error.put(202, "Accepted");
        error.put(203, "Non-Authoritative Information since HTTP/1.1");
        error.put(204, "No Content");
        error.put(205, "Reset Content");
        error.put(206, "Partial Content RFC 7233");
        error.put(207, "Multi-Status WebDAV; RFC 4918");
        error.put(208, "Already Reported WebDAV; RFC 5842");
        error.put(226, "IM Used RFC 3229");
        error.put(300, "Multiple Choices");
        error.put(301, "Moved Permanently");
        error.put(302, "Found Previously Moved temporarily");
        error.put(303, "See Other since HTTP/1.1");
        error.put(304, "Not Modified RFC 7232");
        error.put(305, "Use Proxy since HTTP/1.1");
        error.put(306, "Switch Proxy");
        error.put(307, "Temporary Redirect since HTTP/1.1");
        error.put(308, "Permanent Redirect RFC 7538");
        error.put(400, "Bad Request");
        error.put(401, "Unauthorized RFC 7235");
        error.put(402, "Payment Required");
        error.put(403, "Forbidden");
        error.put(404, "Not Found");
        error.put(405, "Method Not Allowed");
        error.put(406, "Not Acceptable");
        error.put(407, "Proxy Authentication Required RFC 7235");
        error.put(408, "Request Timeout");
        error.put(409, "Conflict");
        error.put(410, "Gone");
        error.put(411, "Length Required");
        error.put(412, "Precondition Failed RFC 7232");
        error.put(413, "Payload Too Large RFC 7231");
        error.put(414, "URI Too Long RFC 7231");
        error.put(415, "Unsupported Media Type RFC 7231");
        error.put(416, "Range Not Satisfiable RFC 7233");
        error.put(417, "Expectation Failed");
        error.put(418, "I'm a teapot RFC 2324, RFC 7168");
        error.put(421, "Misdirected Request RFC 7540");
        error.put(422, "Unprocessable Entity WebDAV; RFC 4918");
        error.put(423, "Locked WebDAV; RFC 4918");
        error.put(424, "Failed Dependency WebDAV; RFC 4918");
        error.put(425, "Too Early RFC 8470");
        error.put(426, "Upgrade Required");
        error.put(428, "Precondition Required RFC 6585");
        error.put(429, "Too Many Requests RFC 6585");
        error.put(431, "Request Header Fields Too Large RFC 6585");
        error.put(451, "Unavailable For Legal Reasons RFC 7725");
        error.put(500, "Internal Server Error");
        error.put(501, "Not Implemented");
        error.put(502, "Bad Gateway");
        error.put(503, "Service Unavailable");
        error.put(504, "Gateway Timeout");
        error.put(505, "HTTP Version Not Supported");
        error.put(506, "Variant Also Negotiates RFC 2295");
        error.put(507, "Insufficient Storage WebDAV; RFC 4918");
        error.put(508, "Loop Detected WebDAV; RFC 5842");
        error.put(510, "Not Extended RFC 2774");
        error.put(511, "Network Authentication Required RFC 6585");
        return error;
    }

}
