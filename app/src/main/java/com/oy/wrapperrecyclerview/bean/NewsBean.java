package com.oy.wrapperrecyclerview.bean;

import java.util.List;

public class NewsBean {

    /**
     * Result : true
     * Info : 查询成功
     * Code : 1
     * Content :
     * DataDict : {"DataList":[{"Id":19,"Title":"国产C919首飞","TitleImageUrl":"http://pic.xhby.net/003/005/359/00300535923_07990739.jpg","Hits":10,"Source":null,"CateId":2,"NewsContent":"首飞","IsShow":true,"Status":1,"CreateTime":"/Date(1553011200000)/","Desc":"test"}]}
     */

    private boolean Result;
    private String Info;
    private int Code;
    private String Content;
    private DataDictBean DataDict;

    public boolean isResult() {
        return Result;
    }

    public void setResult(boolean Result) {
        this.Result = Result;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String Info) {
        this.Info = Info;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int Code) {
        this.Code = Code;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public DataDictBean getDataDict() {
        return DataDict;
    }

    public void setDataDict(DataDictBean DataDict) {
        this.DataDict = DataDict;
    }

    public static class DataDictBean {
        private List<DataListBean> DataList;

        public List<DataListBean> getDataList() {
            return DataList;
        }

        public void setDataList(List<DataListBean> DataList) {
            this.DataList = DataList;
        }

        public static class DataListBean {
            /**
             * Id : 19
             * Title : 国产C919首飞
             * TitleImageUrl : http://pic.xhby.net/003/005/359/00300535923_07990739.jpg
             * Hits : 10
             * Source : null
             * CateId : 2
             * NewsContent : 首飞
             * IsShow : true
             * Status : 1
             * CreateTime : /Date(1553011200000)/
             * Desc : test
             */

            private int Id;
            private String Title;
            private String TitleImageUrl;
            private int Hits;
            private Object Source;
            private int CateId;
            private String NewsContent;
            private boolean IsShow;
            private int Status;
            private String CreateTime;
            private String Desc;

            public int getId() {
                return Id;
            }

            public void setId(int Id) {
                this.Id = Id;
            }

            public String getTitle() {
                return Title;
            }

            public void setTitle(String Title) {
                this.Title = Title;
            }

            public String getTitleImageUrl() {
                return TitleImageUrl;
            }

            public void setTitleImageUrl(String TitleImageUrl) {
                this.TitleImageUrl = TitleImageUrl;
            }

            public int getHits() {
                return Hits;
            }

            public void setHits(int Hits) {
                this.Hits = Hits;
            }

            public Object getSource() {
                return Source;
            }

            public void setSource(Object Source) {
                this.Source = Source;
            }

            public int getCateId() {
                return CateId;
            }

            public void setCateId(int CateId) {
                this.CateId = CateId;
            }

            public String getNewsContent() {
                return NewsContent;
            }

            public void setNewsContent(String NewsContent) {
                this.NewsContent = NewsContent;
            }

            public boolean isIsShow() {
                return IsShow;
            }

            public void setIsShow(boolean IsShow) {
                this.IsShow = IsShow;
            }

            public int getStatus() {
                return Status;
            }

            public void setStatus(int Status) {
                this.Status = Status;
            }

            public String getCreateTime() {
                return CreateTime;
            }

            public void setCreateTime(String CreateTime) {
                this.CreateTime = CreateTime;
            }

            public String getDesc() {
                return Desc;
            }

            public void setDesc(String Desc) {
                this.Desc = Desc;
            }
        }
    }
}
