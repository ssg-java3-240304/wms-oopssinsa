package com.oopssinsa.model.dao;

import com.oopssinsa.model.dto.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.*;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class IbMapperTest {

    private static SqlSession sqlSession;
    private static IbMapper ibMapper;

    @BeforeAll
    static void setUpBeforeClass() {
        // MyBatis 설정 파일을 읽어와서 SqlSessionFactory를 생성
        String resource = "mybatis-config.xml";
        InputStream inputStream = IbMapperTest.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // SqlSessionFactory로부터 SqlSession을 생성
        sqlSession = sqlSessionFactory.openSession();

        // SqlSession을 사용하여 매퍼 인터페이스의 구현체를 생성
        ibMapper = sqlSession.getMapper(IbMapper.class);
    }

    @AfterAll
    static void tearDownAfterClass() {
        // SqlSession을 닫음
        sqlSession.close();
    }

    @BeforeEach
    void setUp() {
        // 테스트마다 롤백 처리
        sqlSession.rollback();
    }

    @Test
    void testUpdateIbState() {
        LocalDate localDate = LocalDate.now();
        // IbDto 객체 생성
        IbDto ibDto = new IbDto("your_id", localDate, "your_product_id", "your_brand_id", 0, localDate, localDate, 'A'); // 적절한 값 설정

        int result = ibMapper.updateIbState(ibDto);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void testUpdateExpectedCapacityLocation() {
        // LocationDto 객체 생성
        LocationDto locationDto = new LocationDto("your_location_id", 'A', "your_section_id", 0, 0, 0); // 적절한 값 설정
        int result = ibMapper.updateExpectedCapacityLocation(locationDto);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void testUpdateExpectedCapacitySection() {
        // SectionDto 객체 생성
        SectionDto sectionDto = new SectionDto('1', "your_section_id", 0, 0, 0); // 적절한 값 설정
        int result = ibMapper.updateExpectedCapacitySection(sectionDto);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void testFindLocationByCategoryIdAndSectionId() {
        // categoryId와 sectionId에 적절한 값을 전달하여 테스트
        String categoryId = "1001"; // 적절한 값 설정
        char sectionId = 'A'; // 적절한 값 설정
        LocationDto result = ibMapper.findLocationByCategoryIdAndSectionId(categoryId, sectionId);
        assertThat(result).isNotNull();
    }

    @Test
    void testFindProductByProductId() {
        // productId에 적절한 값을 전달하여 테스트
        String productId = "AC001"; // 적절한 값 설정
        ProductDto result = ibMapper.findProductByProductId(productId);
        assertThat(result).isNotNull();
    }

    @Test
    void testFindSectionByBrandId() {
        // brandId에 적절한 값을 전달하여 테스트
        String brandId = "7"; // 적절한 값 설정
        SectionDto result = ibMapper.findSectionByBrandId(brandId);
        assertThat(result).isNotNull();
    }

    @Test
    void testFindAllIb() {
        List<IbDto> result = ibMapper.findAllIb();
        assertThat(result).isNotNull();
    }

    @Test
    void testFindIbByState() {
        // status에 적절한 값을 전달하여 테스트
        char status = 'R'; // 적절한 값 설정
        List<IbDto> result = ibMapper.findIbByState(status);
        assertThat(result).isNotNull();
    }

    @Test
    void testFindIbRequestAndLocation() {
        List<IbRequestAndLocationDto> result = ibMapper.findIbRequestAndLocation(); // 수정된 부분
        assertThat(result).isNotNull();
    }
}
