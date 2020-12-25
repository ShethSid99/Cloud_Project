package lambda;

/**
 *
 * @author Wes Lloyd
 */
public class Request {

    String name;
    String bucketname;
    String filename;
    String totalRecords;
    
    String filenameSrc;
    String filenameDest;
    
    String dynamoDBTableName;
    
    String startRecord;
    String endRecord;
    
    String mySQLTable;
    
    public void setMySQLTable(String mySQLTable){
        this.mySQLTable = mySQLTable;
    }
    
    public String getMySQLTable(){
        return this.mySQLTable;
    }
   
    public void setStartRecord(String startRecord){
        this.startRecord = startRecord;
    }
    
    public String getStartRecord(){
        return this.startRecord;
    }
    
    public void setEndRecord(String endRecord){
        this.endRecord = endRecord;
    }
    
    public String getEndRecord(){
        return this.endRecord;
    }
    
    public void setDynamoDBTableName(String tablename){
        this.dynamoDBTableName = tablename;
    }
    
    public String getDynamoDBTableName(){
        return this.dynamoDBTableName;
    }
    
    public String getTotalRecords() {
        return totalRecords;
    }
    
    public void setTotalRecords(String totalRecords) {
        this.totalRecords = totalRecords;
    }

    public String getName() {
        return name;
    }

    public String getBucketname() {
        return bucketname;
    }

    public String getFilename() {
        return filename;
    }
    
    public String getFilenameSrc() {
        return filenameSrc;
    }
    
    public void setFilenameSrc(String filenameSrc) {
        this.filenameSrc = filenameSrc;
    }
    
    public String getFilenameDest() {
        return filenameDest;
    }
    
    public void setFilenameDest(String filenameDest) {
        this.filenameDest = filenameDest;
    }

    public void setBucketname(String bucketname) {
        this.bucketname = bucketname;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    public String getNameALLCAPS() {
        return name.toUpperCase();
    }

    public void setName(String name) {
        this.name = name;
    }

    public Request(String name) {
        this.name = name;
    }

    public Request() {

    }
}
