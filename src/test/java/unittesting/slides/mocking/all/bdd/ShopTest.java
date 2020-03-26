package unittesting.slides.mocking.all.bdd;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

class ShopTest {

    private Seller seller = mock(Seller.class);
    private Bread bread = mock(Bread.class);
    private Shop shop = new Shop(seller);

    @Test
    public void shouldBuyBread() {
        //given
        given(seller.askForBread()).willReturn(new Goods(bread));

        //when
        Goods goods = shop.buyBread();

        //then
        then(seller).should().askForBread();

        assertThat(goods.get(0), instanceOf(Bread.class));
        assertThat(goods.get(0), is(bread));
    }
}