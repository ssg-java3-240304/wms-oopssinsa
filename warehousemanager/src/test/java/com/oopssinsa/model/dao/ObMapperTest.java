package com.oopssinsa.model.dao;

import com.oopssinsa.model.dto.ob.ObDetailDto;
import com.oopssinsa.model.dto.ob.ObDto;
import com.oopssinsa.model.dto.ob.ObRequestDto;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.*;

import java.io.InputStream;
import java.util.List;

import static com.oopssinsa.common.MyBatisTemplate.getSqlSession;
import static org.junit.jupiter.api.Assertions.*;

class ObMapperTest {

    private static SqlSession sqlSession;
    private static ObMapper obMapper;
    @BeforeAll
    static void setUpBeforeClass() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = IbMapperTest.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        obMapper = sqlSession.getMapper(ObMapper.class);
    }

    @BeforeEach
    void setUp() {
        this.sqlSession = getSqlSession();
        this.obMapper = sqlSession.getMapper(ObMapper.class);
    }

    @AfterEach
    void tearDown() {
//      this.sqlSession.commit();
        this.sqlSession.rollback();
        this.sqlSession.close();
    }

    @Disabled
    @Test
    void findObByRequestState() {
        List<ObRequestDto> obRequestDto = obMapper.findObByRequestState();
        System.out.println(obRequestDto);
    }

    @Test
    void findAllOb() {
        List<ObDto> obDtos = obMapper.findAllOb();
        System.out.println(obDtos);
    }

    @Test
    void findAllStock() {
    }

    @Test
    void findStockOrderableByProductId() {
    }

    @Test
    void findObRequestAndStock() {
    }

    @Test
    void updateStock() {
    }

    @Test
    void insertObDetails() {
    }

    @Test
    void updateObState() {
    }

    @Test
    void findObDetailByWaitingState() {
    }

    @Test
    void insertObWorker() {
    }
}