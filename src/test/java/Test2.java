import com.demo.entity.Account;
import com.demo.entity.Img;
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

/**
 * @Author: Ma HaiYang
 * @Description: MircoMessage:Mark_7001
 */
public class Test2 {
    private SqlSession sqlSession;
    @Before
    public void init(){
        SqlSessionFactoryBuilder ssfb =new SqlSessionFactoryBuilder();
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory factory=ssfb.build(resourceAsStream) ;
        sqlSession=factory.openSession();
    }
    @Test
    public void testFindAll(){
        // 调用SQL语句
        List<Account> list = sqlSession.selectList("Account.findAll");
        for (Account account : list) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne(){
        // 调用SQL语句
        Account account = sqlSession.selectOne("Account.findOne");
        System.out.println(account);
    }

    @Test
    public void testInsertOne(){
        // 调用SQL语句
        Account account = new Account(3,"jie",1000000000);
        int insert = sqlSession.insert("Account.insertAccount",account);
        System.out.println(insert);
        sqlSession.commit();
    }

    @Test
    public void testUpdate(){
        // 调用SQL语句
        Account account = new Account(3,"jie",50000);
        int insert = sqlSession.update("Account.updateAccount",account);
        System.out.println(insert);
        sqlSession.commit();
    }

    @Test
    public void testDelete(){
        // 调用SQL语句
        Account account = new Account(3,"jie",1000000000);
        int insert = sqlSession.delete("Account.deleteAccount",3);
        System.out.println(insert);
        sqlSession.commit();
    }

    @After
    public void release(){
        // 关闭SQLSession
        sqlSession.close();
    }
}
