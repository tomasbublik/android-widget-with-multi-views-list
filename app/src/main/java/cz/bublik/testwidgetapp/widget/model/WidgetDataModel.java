package cz.bublik.testwidgetapp.widget.model;

import java.util.Calendar;
import java.util.List;

public class WidgetDataModel {

    private Calendar nearestAlarmDate;

    private Calendar alarmPeriodChange;

    private List<Page> pages;

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

    public Calendar getNearestAlarmDate() {
        return nearestAlarmDate;
    }

    public void setNearestAlarmDate(Calendar nearestAlarmDate) {
        this.nearestAlarmDate = nearestAlarmDate;
    }

    public Calendar getAlarmPeriodChange() {
        return alarmPeriodChange;
    }

    public void setAlarmPeriodChange(Calendar alarmPeriodChange) {
        this.alarmPeriodChange = alarmPeriodChange;
    }

    public static class Page {
        /**
         * placeName : Home
         * items : [{"iconName":"3","itemTitle":"This is cheap","itemSubTitle":"Now active","active":true},{"iconName":"2","itemTitle":"Car charger","itemSubTitle":"Now till 11:30","active":true},{"iconName":"11","itemTitle":"Boiler heat","itemSubTitle":"Inactive","active":false}]
         */

        private String placeName;
        private String icon;
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

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public static class Item {
            /**
             * iconName : 3
             * itemTitle : This is cheap
             * itemSubTitle : Now active
             * active : true
             */

            private String iconName;
            private String itemTitle;
            private String itemSubTitle;
            private boolean active;

            public String getIconName() {
                return iconName;
            }

            public void setIconName(String iconName) {
                this.iconName = iconName;
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
