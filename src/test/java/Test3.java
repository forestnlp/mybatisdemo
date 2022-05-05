import com.demo.entity.Account;
import com.demo.entity.Topic;
import com.demo.mapper.TopicMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @Author: Ma HaiYang
 * @Description: MircoMessage:Mark_7001
 */
public class Test3 {
    private SqlSession sqlSession;

    @Before
    public void init() {
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory factory = ssfb.build(resourceAsStream);
        sqlSession = factory.openSession();
    }

    @Test
    public void testFindAll() {
        // 调用SQL语句
        TopicMapper mapper = sqlSession.getMapper(TopicMapper.class);
        List<Topic> all = mapper.findAll();
        for (Topic topic : all.subList(10, 20)) {
            System.out.println(topic);
        }
    }

    @Test
    public void testFindById() {
        // 调用SQL语句
        TopicMapper mapper = sqlSession.getMapper(TopicMapper.class);
        Topic byId = mapper.findById(15);
        System.out.println(byId);
    }

    @Test
    public void testFindByIdMap() {
        // 调用SQL语句
        TopicMapper mapper = sqlSession.getMapper(TopicMapper.class);
        Map<String, Object> byIdMap = mapper.findByIdMap(15);
        for(Map.Entry<String,Object> entry:byIdMap.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }

    @Test
    public void testFindByName() {
        // 调用SQL语句
        TopicMapper mapper = sqlSession.getMapper(TopicMapper.class);
        List<Topic> list = mapper.findByname("leg");
        list.forEach(System.out::println);
    }

    @Test
    public void testFindByTopicName() {
        // 调用SQL语句
        TopicMapper mapper = sqlSession.getMapper(TopicMapper.class);
        List<Topic> list = mapper.findByTopicName("bra");
        list.forEach(System.out::println);
    }

    @After
    public void release() {
        // 关闭SQLSession
        sqlSession.close();
    }
}
