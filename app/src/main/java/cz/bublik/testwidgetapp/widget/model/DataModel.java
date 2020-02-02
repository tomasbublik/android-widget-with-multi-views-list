package cz.bublik.testwidgetapp.widget.model;

import java.util.List;

public class DataModel {

    private List<Page> pages;

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

    public static class Page {
        /**
         * placeName : Home
         * items : [{"itemIconId":"3","itemTitle":"This is cheap","itemSubTitle":"Now active","active":true},{"itemIconId":"2","itemTitle":"Car charger","itemSubTitle":"Now till 11:30","active":true},{"itemIconId":"11","itemTitle":"Boiler heat","itemSubTitle":"Inactive","active":false}]
         */

        private String placeName;
        private List<Item> items;

        public String getPlaceName() {
            return placeName;
        }

        public void setPlaceName(String placeName) {
            this.placeName = placeName;
        }

        public List<Item> getItems() {
            return items;
        }

        public void setItems(List<Item> items) {
            this.items = items;
        }

        public static class Item {
            /**
             * itemIconId : 3
             * itemTitle : This is cheap
             * itemSubTitle : Now active
             * active : true
             */

            private String itemIconId;
            private String itemTitle;
            private String itemSubTitle;
            private boolean active;

            public String getItemIconId() {
                return itemIconId;
            }

            public void setItemIconId(String itemIconId) {
                this.itemIconId = itemIconId;
            }

            public String getItemTitle() {
                return itemTitle;
            }

            public void setItemTitle(String itemTitle) {
                this.itemTitle = itemTitle;
            }

            public String getItemSubTitle() {
                return itemSubTitle;
            }

            public void setItemSubTitle(String itemSubTitle) {
                this.itemSubTitle = itemSubTitle;
            }

            public boolean isActive() {
                return active;
            }

            public void setActive(boolean active) {
                this.active = active;
            }
        }
    }
}
