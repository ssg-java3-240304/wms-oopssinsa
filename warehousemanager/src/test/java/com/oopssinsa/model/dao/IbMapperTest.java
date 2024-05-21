package com.oopssinsa.model.dao;

import com.oopssinsa.model.dto.*;
import com.oopssinsa.model.dto.ib.IbDto;
import com.oopssinsa.model.dto.ib.IbRequestAndLocationDto;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.*;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.oopssinsa.common.MyBatisTemplate.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;

class IbMapperTest {

    private static SqlSession sqlSession;
    private static IbMapper ibMapper;

    @BeforeAll
    static void setUpBeforeClass() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = IbMapperTest.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        ibMapper = sqlSession.getMapper(IbMapper.class);
    }

    @BeforeEach
    void setUp() {
        this.sqlSession = getSqlSession();
        this.ibMapper = sqlSession.getMapper(IbMapper.class);
    }

    @AfterEach
    void tearDown() {
        this.sqlSession.commit();
        this.sqlSession.close();
    }

    @Test
    void testUpdateIbState() {
        IbDto ibDto = new IbDto("1", LocalDate.of(2023, 11, 1), "AAA", "Aa", 11, LocalDate.of(2024, 5, 19), LocalDate.of(2024, 5, 20), 'P');
        ibMapper.updateIbState(ibDto);
        sqlSession.commit();
    }

//    @Test
//    void testUpdateExpectedCapacityLoc() {
//        // LocationDto 생성자의 인자 중 'A'를 적절한 숫자 값으로 변경
//        LocationDto locationDto = new LocationDto('B', "1001", 840, 10, 4600);
//        ibMapper.updateExpectedCapacityLocation(locationDto);
//        sqlSession.commit();
//        System.out.println(locationDto);
//    }

    @Test
    void testUpdateExpectedCapacitySec() {
        // LocationDto 생성자의 인자 중 'A'를 적절한 숫자 값으로 변경
        SectionDto sectionDto = new SectionDto('B', "1001", 840, 10, 4600);
        ibMapper.updateExpectedCapacitySection(sectionDto);
        sqlSession.commit();
        System.out.println(sectionDto);
    }

    @Test
    void testFindAllIb() {
        List<IbDto> result = ibMapper.findAllIb();
        assertThat(result).isNotNull();
    }

    @Test
    void testFindIbByRequestState() {
        List<IbDto> result = ibMapper.findIbByRequestState();
        assertThat(result).isNotEmpty();
        assertThat(result.get(0).getStatus()).isEqualTo('R');
    }

    @Test
    void testFindIbByWaitingState() {
        List<IbDto> result = ibMapper.findIbByWaitingState();
        assertThat(result).isNotEmpty();
        assertThat(result.get(0).getStatus()).isEqualTo('W');
    }

//    @Disabled
//    @Test
//    void testFindIbRequestAndLocation() {
//        List<IbDto> ibDtos = ibMapper.findAllIb(); // IbService에서 모든 IbDto를 가져옴
//        List<IbRequestAndLocationDto> results = ibMapper.findIbRequestAndLocation(ibDtos);
//        assertThat(results).isNotNull();
//        assertThat(results).isNotEmpty();
//
//        // 결과 검증
//        for (IbRequestAndLocationDto result : results) {
//            assertThat(result.getIbStatus()).isEqualTo('R');
//            assertThat(result.getBrandId()).isNotNull();
//            assertThat(result.getMaxCapacity()).isGreaterThan(0);
//        }
//    }

    @Test
    void testFindIbRequestAndLocation() {

        // 테스트 데이터 준비
        List<IbDto> ibDtos = new ArrayList<>();
        ibDtos.add(new IbDto("1", LocalDate.of(2024, 5, 19), "TS001", "1", 100, LocalDate.now(), null, 'R'));
        ibDtos.add(new IbDto("1", LocalDate.of(2024, 5, 19), "JK002", "3", 50, LocalDate.now(), null, 'R'));

        // 메소드 실행
        List<IbRequestAndLocationDto> results = ibMapper.findIbRequestAndLocation(ibDtos);

        for (IbRequestAndLocationDto result : results) {
            System.out.println(result.toString());
            System.out.println(results.size());
        }

        // 결과 검증
        assertThat(results).isNotNull();
        assertThat(results).isNotEmpty();
        assertThat(results.size()).isEqualTo(ibDtos.size()); // 결과의 크기가 입력 리스트의 크기와 같은지 확인

//        // 상세 결과 검증
//        for (IbRequestAndLocationDto result : results) {
//            assertThat(result.getIbStatus()).isEqualTo('R'); // 가정된 상태 값
//            assertThat(result.getBrandId()).isNotNull();
//            assertThat(result.getMaxCapacity()).isGreaterThan(0);
//            assertThat(result.getIbAvailability()).isEqualTo('T'); // 입고 가능 상태 검증
//        }
    }
}

