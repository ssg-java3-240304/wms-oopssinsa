package com.oopssinsa.model.dao;

import com.oopssinsa.model.dto.StockDto;
import com.oopssinsa.model.dto.ob.ObDetailDto;
import com.oopssinsa.model.dto.ob.ObDto;
import com.oopssinsa.model.dto.ob.ObRequestAndStockDto;
import com.oopssinsa.model.dto.ob.ObRequestDto;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.*;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;

import static com.oopssinsa.common.MyBatisTemplate.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;
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
        System.out.println(obMapper.findAllStock());
    }

    @Test
    void findStockOrderableByProductId() {
        List<StockDto> stockDtos = obMapper.findStockOrderableByProductId("TS002");
        System.out.println(stockDtos);
    }

    @Test
    void findObRequestAndStock() {
        List<ObRequestAndStockDto> obRequestAndStockDtos = obMapper.findObRequestAndStock();
        System.out.println(obRequestAndStockDtos);
    }

//    @Disabled
    @Test
    void updateStock() {
        LocalDate localDate = LocalDate.of(2023, 6, 21);
        StockDto stockDto = new StockDto(localDate, "TS002", "B", 319, 0);
        int result = obMapper.updateStock(stockDto);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void insertObDetails() {
        LocalDate localDate = LocalDate.of(2023,7,21);
        ObDetailDto obDetailDto = new ObDetailDto(localDate, "1240521", "SH004", 2, 'W', null, null, null);
        int result = obMapper.insertObDetails(obDetailDto);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void updateObState() {
        LocalDate localDate = LocalDate.of(2023,5,5);

        ObDetailDto obDetailDto = new ObDetailDto(localDate, "1240521", "SH001", 1, 'P', null, null, null);
        int result = obMapper.updateObState(obDetailDto);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void findObDetailByWaitingState() {
        List<ObDetailDto> obDetailDtos = obMapper.findObDetailByWaitingState();
        assertThat(obDetailDtos).isNotNull().isNotEmpty();
    }

//    @Test
//    void insertObWorker() {
//
//    }
}