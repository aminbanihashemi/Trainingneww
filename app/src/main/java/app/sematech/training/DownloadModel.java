package app.sematech.training;

import com.orm.SugarRecord;

public class DownloadModel extends SugarRecord<DownloadModel>{
    public String url;
    public String downloadedAddress;
    public String date;

    public DownloadModel(String url, String downloadedAddress, String date) {
        super();
        this.url = url;
        this.downloadedAddress = downloadedAddress;
        this.date = date;
    }

    public DownloadModel() {
        super();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDownloadedAddress() {
        return downloadedAddress;
    }

    public void setDownloadedAddress(String downloadedAddress) {
        this.downloadedAddress = downloadedAddress;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
