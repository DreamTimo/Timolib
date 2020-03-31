package com.timo.timolib.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 蔡永汪 on 2020/3/19.
 */

public class ImBean implements Serializable{

    /**
     * code : 0
     * data : {"5个工作日内完成居民用户新用水申请的查勘、设计。15个工作日内完成对具备接水条件的大用户新用水申请的查勘、设计，设计变更率不超过10%。对办理接水申请的用户在缴齐工程预付款后30个工作日内安排施工。供水管网工程验收合格并在用户履行完相关手续后5个工作日内开始安装水表。":[-151.17184239732654,"申请装表多长时间能装好？"],"参看答案2。":[-369.8555657383689,"江办中法联系方式是什么？"],"参看答案3。":[-369.41635463531264,"江办中法营业所的地址、联系电话和服务范围是什么？"]}
     * message : success
     */

    private int code;
    private DataBean data;
    private String   message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        @SerializedName("5个工作日内完成居民用户新用水申请的查勘、设计。15个工作日内完成对具备接水条件的大用户新用水申请的查勘、设计，设计变更率不超过10%。对办理接水申请的用户在缴齐工程预付款后30个工作日内安排施工。供水管网工程验收合格并在用户履行完相关手续后5个工作日内开始安装水表。")
        private List<Double> _$_5151030585; // FIXME check this code
        @SerializedName("参看答案2。")
        private List<Double> _$2229; // FIXME check this code
        @SerializedName("参看答案3。")
        private List<Double> _$3297; // FIXME check this code

        public List<Double> get_$_5151030585() {
            return _$_5151030585;
        }

        public void set_$_5151030585(List<Double> _$_5151030585) {
            this._$_5151030585 = _$_5151030585;
        }

        public List<Double> get_$2229() {
            return _$2229;
        }

        public void set_$2229(List<Double> _$2229) {
            this._$2229 = _$2229;
        }

        public List<Double> get_$3297() {
            return _$3297;
        }

        public void set_$3297(List<Double> _$3297) {
            this._$3297 = _$3297;
        }
    }
}
