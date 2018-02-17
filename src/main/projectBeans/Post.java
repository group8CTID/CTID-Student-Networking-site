package Main.projectBeans;

public class Post {
    private String postId;
    private String postName;
    private String postCategory;
    private String subCategory;
    private String postLocation;
    private String postImage;
    private String postDate;

    public Post() {
    }

    public Post(String postId, String postName, String postCategory, String subCategory,
                String postLocation, String postImage, String postDate) {
        this.postId = postId;
        this.postName = postName;
        this.postCategory = postCategory;
        this.subCategory = subCategory;
        this.postLocation = postLocation;
        this.postImage = postImage;
        this.postDate = postDate;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPostCategory() {
        return postCategory;
    }

    public void setPostCategory(String postCategory) {
        this.postCategory = postCategory;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getPostLocation() {
        return postLocation;
    }

    public void setPostLocation(String postLocation) {
        this.postLocation = postLocation;
    }

    public String getPostImage() {
        return postImage;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public String createdDate(){
        String date = null;


        return date;
    }
}
