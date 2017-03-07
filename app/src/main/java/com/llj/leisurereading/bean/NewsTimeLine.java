package com.llj.leisurereading.bean;

import java.util.List;

/**
 * Created by llj on 2017/3/7.
 */

public class NewsTimeLine {

  /**
   * date : 20170307
   * stories : [{"images":["http://pic2.zhimg.com/c605effbb908e10d62969998b76aa7e1.jpg"],"type":0,"id":9269781,"ga_prefix":"030709","title":"这样一分析，你就明白该在哪里投广告了"},{"images":["http://pic2.zhimg.com/882f6e9f6c7687a432d1f9ed1c0fd635.jpg"],"type":0,"id":9269183,"ga_prefix":"030708","title":"有些热闹的「共享经济」，恐怕只是一个美好的童话"},{"images":["http://pic3.zhimg.com/94fb217c36ee60ec212fbe57609b5c4a.jpg"],"type":0,"id":9268452,"ga_prefix":"030707","title":"让孩子拥有属于自己的无聊时光，到底有多重要？"},{"images":["http://pic3.zhimg.com/ca1daa8c452e8e2b39eae6492977eac6.jpg"],"type":0,"id":9269792,"ga_prefix":"030707","title":"看不懂，说人话，不然公司就亏大发了"},{"images":["http://pic4.zhimg.com/3a5b378504a4b3f192aacc1794bb8503.jpg"],"type":0,"id":9269818,"ga_prefix":"030707","title":"《金刚狼 3》中有哪些隐藏的彩蛋和有趣的细节？"},{"images":["http://pic2.zhimg.com/23b98f347a73a6f2d165998ac2922afd.jpg"],"type":0,"id":9266807,"ga_prefix":"030706","title":"瞎扯 · 如何正确地吐槽"}]
   * top_stories : [{"image":"http://pic2.zhimg.com/05c67496e38f662958a141847a734ffd.jpg","type":0,"id":9269183,"ga_prefix":"030708","title":"有些热闹的「共享经济」，恐怕只是一个美好的童话"},{"image":"http://pic3.zhimg.com/8b1588e23187bb05d160d599bbfe1752.jpg","type":0,"id":9269818,"ga_prefix":"030707","title":"《金刚狼 3》中有哪些隐藏的彩蛋和有趣的细节？"},{"image":"http://pic3.zhimg.com/e887238b71206814d6155afb2d773296.jpg","type":0,"id":9268717,"ga_prefix":"030617","title":"ofo 说自己融资4.5 亿美金，真的有这么多吗？"},{"image":"http://pic3.zhimg.com/e056f419dcf7987e7cd968640281d946.jpg","type":0,"id":9268431,"ga_prefix":"030616","title":"会计从业资格考试将被取消，我觉得可能是好事"},{"image":"http://pic4.zhimg.com/3c2492bbd6464c2e51e737dc4ded9647.jpg","type":0,"id":9266554,"ga_prefix":"030608","title":"离职前需要注意哪些细节？"}]
   */

  private String date;
  private List<StoriesBean> stories;
  private List<TopStoriesBean> top_stories;

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public List<StoriesBean> getStories() {
    return stories;
  }

  public void setStories(List<StoriesBean> stories) {
    this.stories = stories;
  }

  public List<TopStoriesBean> getTop_stories() {
    return top_stories;
  }

  public void setTop_stories(List<TopStoriesBean> top_stories) {
    this.top_stories = top_stories;
  }

  public static class StoriesBean {

    /**
     * images : ["http://pic2.zhimg.com/c605effbb908e10d62969998b76aa7e1.jpg"]
     * type : 0
     * id : 9269781
     * ga_prefix : 030709
     * title : 这样一分析，你就明白该在哪里投广告了
     */

    private int type;
    private int id;
    private String ga_prefix;
    private String title;
    private List<String> images;

    public int getType() {
      return type;
    }

    public void setType(int type) {
      this.type = type;
    }

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getGa_prefix() {
      return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
      this.ga_prefix = ga_prefix;
    }

    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }

    public List<String> getImages() {
      return images;
    }

    public void setImages(List<String> images) {
      this.images = images;
    }
  }

  public static class TopStoriesBean {

    /**
     * image : http://pic2.zhimg.com/05c67496e38f662958a141847a734ffd.jpg
     * type : 0
     * id : 9269183
     * ga_prefix : 030708
     * title : 有些热闹的「共享经济」，恐怕只是一个美好的童话
     */

    private String image;
    private int type;
    private int id;
    private String ga_prefix;
    private String title;

    public String getImage() {
      return image;
    }

    public void setImage(String image) {
      this.image = image;
    }

    public int getType() {
      return type;
    }

    public void setType(int type) {
      this.type = type;
    }

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getGa_prefix() {
      return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
      this.ga_prefix = ga_prefix;
    }

    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }
  }
}
