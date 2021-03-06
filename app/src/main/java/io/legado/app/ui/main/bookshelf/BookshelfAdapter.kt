package io.legado.app.ui.main.bookshelf

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import io.legado.app.data.entities.BookGroup
import io.legado.app.ui.main.bookshelf.books.BooksFragment


class BookshelfAdapter(fragment: Fragment, val callBack: CallBack) :
    FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return callBack.groupSize
    }

    override fun createFragment(position: Int): Fragment {
        val groupId = callBack.getGroup(position).groupId
        return BooksFragment.newInstance(position, groupId)
    }

    interface CallBack {
        val groupSize: Int
        fun getGroup(position: Int): BookGroup
    }
}