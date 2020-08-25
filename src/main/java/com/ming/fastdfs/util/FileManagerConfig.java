package com.ming.fastdfs.util;

import java.io.Serializable;

/**
 * Created by 86189 on 2020/8/6.
 */
public interface FileManagerConfig extends Serializable {

    String PROTOCOL = "http://";

    String SEPARATOR = "/";

    String TRACKER_NGNIX_ADDR = "172.20.60.19";
//    String TRACKER_NGNIX_ADDR = "192.168.56.100";

    String TRACKER_NGNIX_PORT = "8888";

    String CLIENT_CONFIG_FILE = "fastdfs-client.properties";
}
