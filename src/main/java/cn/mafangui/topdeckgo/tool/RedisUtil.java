package cn.mafangui.topdeckgo.tool;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 指定缓存失效时间
     * @param key 键
     * @param time 秒
     * @return
     */
    public boolean expire(String key,long time){
        try {
            if (time>0)
                redisTemplate.expire(key,time, TimeUnit.SECONDS);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取key失效时间
     * @param key
     * @return
     */
    public long getExpire(String key){
        if (!hasKey(key)) return 0;
        return redisTemplate.getExpire(key,TimeUnit.SECONDS);
    }

    /**
     * 是否存在key
     * @param key
     * @return
     */
    public boolean hasKey(String key){
        try {
            return redisTemplate.hasKey(key);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除缓存
     * @param key
     */
    public void del(String... key){
        if (key!=null&& key.length > 0){
            if (key.length==1){
                redisTemplate.delete(key[0]);
            }else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    /**
     * 获取缓存
     * @param key
     * @return
     */
    public Object get(String key){
        return key==null?null:redisTemplate.opsForValue().get(key);
    }

    /**
     * 放入缓存
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key,Object value){
        try {
            redisTemplate.opsForValue().set(key,value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 放入缓存并设置失效时间
     * @param key
     * @param value
     * @param time
     * @return
     */
    public boolean set(String key,Object value,long time){
        try {
            if (time>0)
                redisTemplate.opsForValue().set(key,value);
            else set(key,value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
